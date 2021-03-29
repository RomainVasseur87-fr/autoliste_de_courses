package m2i.formation.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import m2i.formation.dao.IProcessDao;
import m2i.formation.model.Process;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/process")
public class ProcessApiRestController {
	
	@Autowired
	private IProcessDao processDao;

	@GetMapping("")
	public List<Process> list() {
		List<Process> process = processDao.findAll();
		return process;
	}

	@GetMapping("/{id}")
	public Process find(@PathVariable Long id) {
		Optional<Process> optProcess = processDao.findById(id);
		if (optProcess.isPresent()) {
			return optProcess.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("nom/{nom}")
	public List<Process> findProcessByNom(@PathVariable String nom) {
		List<Process> optProcess = processDao.findProcessByNom(nom);
		return optProcess;
	}

	@GetMapping("description/{description}")
	public List<Process> findProcessByDescription(@PathVariable String description) {
		List<Process> optProcess = processDao.findProcessByDescription(description);
		return optProcess;
	}
	
	@PostMapping("")
	public Process create(@RequestBody Process process) {
		process = processDao.save(process);
		return process;
	}

	@PutMapping("/{id}")
	public Process update(@RequestBody Process process, @PathVariable Long id) {
		if (!processDao.existsById(id) || !id.equals(process.getId())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		process = processDao.save(process);
		return process;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!processDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		processDao.deleteById(id);
		if (processDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Unable to find resource");
		}
	}
	
}