package certification.jdbc;

public class SqlQueryHandler {

    public String getBaseSelectQuery() {
        return "select * from student";
    }

    public String getBaseSelectQueryWithConditions() {
        return "select * from student where";
    }

    public String getDeleteQuery(int id){
        return "delete from student where id = " + id;
    }

    public String getInsertQuery(){
        return "insert into student(name, age, gender, faculty) values(?,?,?,?)";
    }

}
