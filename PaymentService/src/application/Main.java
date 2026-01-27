import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

void main() {

    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    System.out.println("Entre com os dados do contrato: ");
    System.out.print("Número: ");
    int number = sc.nextInt();
    System.out.print("Data (dd/MM/yyyy): ");
    LocalDate date = LocalDate.parse(sc.next(), fmt);
    System.out.print("Valor do contrato: ");
    double totalValue = sc.nextDouble();

    Contract obj = new Contract(number,date,totalValue);

    System.out.print("Entre com o número de parcelas: ");
    int n = sc.nextInt();

    ContractService contractService = new ContractService(new PaypalService());

    contractService.processContract(obj, n);

    System.out.println("Parcerlas: ");
    for (Installment installment : obj.getInstallments()) {
        System.out.println(installment);
    }

    sc.close();
}
