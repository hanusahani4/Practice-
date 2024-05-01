package pracite.service;

import java.util.List;
import java.util.Optional;

import pracite.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pracite.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo employeeRepository;

	@Override
	public List<User> getAllUser() {
		return employeeRepository.findAll();
	}

	@Override
	public void saveUser(User employee) {
		this.employeeRepository.save(employee);
	}

	@Override
	public User getUserById(long id) {
		Optional<User> optional = employeeRepository.findById(id);
		User user = null;
		if (optional.isPresent()) {
			user = optional.get();
		} else {
			throw new RuntimeException(" Employee not found for id :: " + id);
		}
		return user;
	}
}
