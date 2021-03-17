package m2i.formation.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import m2i.formation.dao.ITypeDao;
import m2i.formation.model.Type;

@RestController
@RequestMapping("/api/type")
public class TypeApiRestController {

	@Autowired
	private ITypeDao typeDao;

	@GetMapping("")
	public List<Type> list() {
		List<Type> types = typeDao.findAll();
		return types;
	}

	@GetMapping("/{id}")
	public Type find(@PathVariable Long id) {
		Optional<Type> optType = typeDao.findById(id);

		if (optType.isPresent()) {
			return optType.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("")
	public Type create(@RequestBody Type type) {
		type = typeDao.save(type);

		return type;
	}

	@PutMapping("/{id}")
	public Type update(@RequestBody Type type, @PathVariable Long id) {
		if (!typeDao.existsById(id) || !id.equals(type.getId())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		type = typeDao.save(type);

		return type;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!typeDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		typeDao.deleteById(id);

		if (typeDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Unable to find resource");
		}
	}

}
