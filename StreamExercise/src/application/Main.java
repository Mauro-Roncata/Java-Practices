import entities.Employee;

void main() {

    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter full file path: ");
    String path = sc.nextLine();

    try (BufferedReader br = new BufferedReader(new FileReader(path))) {

        List<Employee> employeeList = new ArrayList<>();

        String line = br.readLine();
        while (line != null) {
            String[] fields = line.split(",");
            employeeList.add(new Employee(fields[0], Double.parseDouble(fields[2]), fields[1]));
            line = br.readLine();
        }

        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();

        List<String> emailSalary = employeeList.stream()
                .filter(x -> x.getSalary() > salary)
                .map(x -> x.getEmail())
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Email of pepople whose salary is more than" + salary);
        emailSalary.forEach(System.out::println);

        double sum = employeeList.stream()
                .filter(x -> x.getName().startsWith("M"))
                .mapToDouble(x -> x.getSalary())
                .sum();

        System.out.print("Sum of salary of people whose name starts with M: " + sum);


    } catch (IOException e) {
        System.out.println("Error: " + e.getMessage());
    }



}
