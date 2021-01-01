package com.roadrunner.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.ui.Model;
import com.roadrunner.app.exception.ResourceNotFoundException;
import com.roadrunner.app.model.Level;
import com.roadrunner.app.repository.LevelRepository;


@Controller
public class LevelController {
	@Autowired
	private LevelRepository levelRepository;

	@GetMapping("/")
    public RedirectView redirect(
      RedirectAttributes attributes) {
        return new RedirectView("level/1");
    }

	@GetMapping("/level")
    public RedirectView redirectFromLevel(
      RedirectAttributes attributes) {
        return new RedirectView("level/1");
    }


	@GetMapping("/level/{id}")
	public String getLevelById(@PathVariable(value = "id") Long levelId)
			throws ResourceNotFoundException {
		levelRepository.findById(levelId) 
				.orElseThrow(() -> new ResourceNotFoundException("Level not found for this id :: " + levelId));
		return String.valueOf(levelId);
	}



	@GetMapping("/levels")
	@ResponseBody
	public List<Level> getAllLevels() {
		return levelRepository.findAll();
    }
    

	// @GetMapping(path = "/level/{id}")
	// public ResponseEntity<Level> getLevelById(@PathVariable(value = "id") Long levelId)
	// 		throws ResourceNotFoundException {
	// 	Level level = levelRepository.findById(levelId)
	// 			.orElseThrow(() -> new ResourceNotFoundException("Level not found for this id :: " + levelId));
	// 	return ResponseEntity.ok().body(level);
	// }

	@PostMapping(path = "/level", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Level createLevel( @RequestBody Level level) {
		return levelRepository.save(level);
    }
    
    // @PutMapping("/levels/{id}")
	// public ResponseEntity<Level> updateLevel(@PathVariable(value = "id") Long levelId,
	// 		 @RequestBody Level levelDetails) throws ResourceNotFoundException {
	// 	Level level = levelRepository.findById(levelId)
	// 			.orElseThrow(() -> new ResourceNotFoundException("Level not found for this id :: " + levelId));

	// 	level.setLevelData(levelDetails.getLevelData());
	// 	level.setLevelName(levelDetails.getLevelName());
	// 	final Level updatedLevel = levelRepository.save(level);
	// 	return ResponseEntity.ok(updatedLevel);
	// }

	// @DeleteMapping("/levels/{id}")
	// public Map<String, Boolean> deleteLevel(@PathVariable(value = "id") Long levelId)
	// 		throws ResourceNotFoundException {
	// 	Level level = levelRepository.findById(levelId)
	// 			.orElseThrow(() -> new ResourceNotFoundException("Level not found for this id :: " + levelId));

	// 	levelRepository.delete(level);
	// 	Map<String, Boolean> response = new HashMap<>();
	// 	response.put("deleted", Boolean.TRUE);
	// 	return response;
	// }
}