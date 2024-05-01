package pracite.service;

import java.util.List;

import pracite.model.User;
import org.springframework.data.domain.Page;

public interface UserService {

	public List<User> getAllUser();
	public void saveUser(User user);
	public User getUserById(long id);
}
