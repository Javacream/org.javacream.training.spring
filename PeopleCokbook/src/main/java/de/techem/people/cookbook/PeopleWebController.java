package de.techem.people.cookbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeopleWebController {

	@Autowired private PeopleService peopleService;

	@GetMapping(path = "people/{id}", produces = "application/json")
	public Person findById(@PathVariable("id") Long id) {
		return peopleService.findById(id);
	}
	
}
