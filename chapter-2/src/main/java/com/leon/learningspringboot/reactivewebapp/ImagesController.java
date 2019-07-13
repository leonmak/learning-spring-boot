package com.leon.learningspringboot.reactivewebapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
public class ImagesController {

	Logger logger = LoggerFactory.getLogger(ImagesController.class);

	@GetMapping("/images")
	Flux<Image> images() {
		return Flux.just(
			new Image("1", "reading.jpg"),
			new Image("2", "reading.jpg")
		);
	}

	@PostMapping("/images")
	Mono<Void> create(@RequestBody Flux<Image> images) {
		return images.map(image -> {
			logger.info("Saving #" + image.getId() + " to a rx db..");
			return image;
		}).then();
	}

}