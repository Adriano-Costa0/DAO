import java.util.ArrayList;
import java.util.List;

public class ConcreteUserDAO implements UserDAO {

  List<User> users = new ArrayList<User>();

  public ConcreteUserDAO() {

    loadFakeUsers(users);
  }

  @Override
  public List<User> getAllUsers() {
    return users;
  }

  @Override
  public User getUser(int id) {
    int userIndex = this.findUserIndex(id);

    if (userIndex == -1) {
      throw new UnsupportedOperationException("USER NOT FOUND");
    } else {
      return users.get(userIndex);
    }

  }

  @Override
  public void updateUser(User user) {
    int updateUserIndex = this.findUserIndex(user.getId());
    users.set(updateUserIndex, user);
  }

  @Override
  public void deleteUser(User user) {
    int userIndex = this.findUserIndex(user.getId());

    if (userIndex == -1) {
      throw new UnsupportedOperationException("USER NOT FOUND");
    } else {
      users.remove(userIndex);
    }
  }

  private int findUserIndex(int id) {

    int userIndex = -1;

    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getId() == id) {
        userIndex = i;
        break;
      }
    }
    if (userIndex == -1) {
      return -1;
    } else {
      return userIndex;
    }
  }

  private List<User> loadFakeUsers(List<User> list) {
    User adriano = new User();
    adriano.setName("Adriano Costa Araujo Morais");
    adriano.setEmail("adriano@gmail.com");
    adriano.setId(0);

    User paulo = new User();
    paulo.setName("paulo rodrigues");
    paulo.setEmail("paulo@gmail.com");
    paulo.setId(1);

    User lucas = new User();
    lucas.setName("lucas Silva");
    lucas.setEmail("lucas@gmail.com");
    lucas.setId(2);

    User andressa = new User();
    andressa.setName("andressa mello");
    andressa.setEmail("andressa@gmail.com");
    andressa.setId(3);

    list.add(adriano);
    list.add(paulo);
    list.add(lucas);
    list.add(andressa);
    return list;
  }
}