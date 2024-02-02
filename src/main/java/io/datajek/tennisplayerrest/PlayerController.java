package io.datajek.tennisplayerrest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {
	@Autowired
	PlayerService service;
	
	@GetMapping("/welcome")
	public String welcome() {
	    return "Tennis Player REST API";
	}
	
	@GetMapping("/players")
	public List<Player> getAllPlayers() {
		return service.getAllPlayers();
	}
	
	@GetMapping("/players/{id}")
	public Player getPlayer(@PathVariable int id) {
		return service.getPlayer(id);
	}
	
	@PostMapping("/players")
	public Player addPlayer(@RequestBody Player player) {
		player.setId(0);
	    return service.addPlayer(player);
	}
	
	@PutMapping("/players/{id}")
	public Player updatePlayer(@RequestBody Player player, @PathVariable int id) {
	    return service.updatePlayer(id, player);
	}
	
	@PatchMapping("/players/{id}")
	public Player partialUpdate( @PathVariable int id, 
	                             @RequestBody Map<String, Object> playerPatch) {
	    return service.patch(id, playerPatch);          
	}
	
	@PatchMapping("/players/{id}/titles")
	public void updateTitles(@PathVariable int id, @RequestBody int titles) {
	    service.updateTitles(id, titles);           
	}
	
	@DeleteMapping("/players/{id}")
	public void deletePlayer(@PathVariable int id) {
	    service.deletePlayer(id);        
	}
}
