import java.util.List;

public class Main {
  public static void main(String[] args) {
    UserDAO userDao = new ConcreteUserDAO();

    List<User> users = userDao.getAllUsers();

    System.out.println("Todos usuarios: ");
    for (User user : users) {
      System.out.println("Nome: " + user.getName() + "; E-mail: " + user.getEmail() + "; ID: " + user.getId());
    }

    User findUser = userDao.getUser(2);

    System.out.println(
        "\nUsuario encontrado: " + findUser.getName() + "; E-mail: " + findUser.getEmail() + "; ID: " + findUser.getId());

    findUser.setEmail("achado@gmail.com123");
    userDao.updateUser(findUser);

    System.out.println(
        "\nUsuario atualizado: " + findUser.getName() + "; E-mail: " + findUser.getEmail() + "; ID: " + findUser.getId());

    userDao.deleteUser(userDao.getUser(0));

    System.out.println("\nTodos usuarios: ");
    for (User user : userDao.getAllUsers()) {
      System.out.println("Nome: " + user.getName() + "; E-mail: " + user.getEmail() + "; ID: " + user.getId());
    }

  }
}