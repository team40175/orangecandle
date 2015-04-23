package com.orangecandle.domain;

import javax.persistence.Column;
import javax.persistence.Id;

public class Room {
	private @Id Integer id;
	private @Column(name = "ide") String identifier;
}
