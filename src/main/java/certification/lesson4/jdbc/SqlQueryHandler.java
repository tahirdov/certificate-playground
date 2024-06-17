package certification.lesson4.jdbc;

public class SqlQueryHandler {

    public String getBaseSelectQuery() {
        return "select * from students";
    }

    public String getBaseSelectQueryWithConditions() {
        return "select * from students where ";
    }

    public String getDeleteQuery(int id){
        return "delete from students where id = " + id;
    }

    public String getInsertQuery(){
        return "insert into students(name, age, gender, faculty) values(?,?,?,?)";
    }

}
