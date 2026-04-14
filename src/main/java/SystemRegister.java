import java.util.List;

public class SystemRegister {
    public static void main(String[] args) {
        ConnectionDb.connect();

        RegisterRepository repository = new RegisterRepository();

        /*
        Register register = new Register();
        List<Register> registers = repository.list();

        for(Register r: registers) {
            System.out.println(r.getId() + " " + r.getName());
        }
         */

        Register register = repository.get(3);
        if(register != null) {
            System.out.println(register.getId() + " " + register.getName());
        } else {
            System.err.println("Register not exists, check the parameters and try again.");
        }
    }
}
