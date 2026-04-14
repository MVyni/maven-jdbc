import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RegisterRepository {
    private Connection connection;

    public RegisterRepository() {
        connection = ConnectionDb.getConnection();
    }

    public void create(Register register) {
        try {
            String sqlRegister = "INSERT INTO public.tab_register (name, age) VALUES(?, ?);";

            PreparedStatement pst = connection.prepareStatement(sqlRegister);
            pst.setString(1, register.getName());
            pst.setInt(2, register.getAge());
            pst.execute();

            System.out.println("Register inserted successfully");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    };

    public void update(Register register) {
        try {
            String sqlUpdate = "UPDATE public.tab_register\n SET name=?, age=? WHERE id=?";

            PreparedStatement pst = connection.prepareStatement(sqlUpdate);
            pst.setString(1, register.getName());
            pst.setInt(2, register.getAge());
            pst.setInt(3, register.getId());
            pst.execute();

            System.out.println("User updated successfully");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    };

    public void delete(Integer id) {
        try {
            String sqlDelete = "DELETE FROM public.tab_register\n WHERE id=?";

            PreparedStatement pst = connection.prepareStatement(sqlDelete);
            pst.setInt(1, id);
            pst.execute();

            System.out.println("User deleted successfully");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    };

    public List<Register> list() {
        List<Register> list = new ArrayList<>();

        try {

            String sql = "SELECT id, name, age FROM public.tab_register";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while(result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                int age = result.getInt("age");

                Register register = new Register();
                register.setId(id);
                register.setName(name);
                register.setAge(age);

                list.add(register);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    };

    public Register get(Integer id) {
        Register register = null;

        try {
            String sql = "SELECT id, name, age FROM public.tab_register WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if(result.next()) {
                id = result.getInt("id");
                String name = result.getString("name");
                int age = result.getInt("age");

                register = new Register();
                register.setId(id);
                register.setName(name);
                register.setAge(age);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return register;
    }
}
