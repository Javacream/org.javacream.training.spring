package de.techem.people.cookbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {

	@Autowired private PeopleRepository peopleRepository;
	public Person findById(Long id) {
		return peopleRepository.findById(id).get();
	}
}
