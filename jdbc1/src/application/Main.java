import db.DB;

import java.sql.Connection;

void main() {

    Connection conn = DB.getConnection();
    DB.closeConnection();

}
