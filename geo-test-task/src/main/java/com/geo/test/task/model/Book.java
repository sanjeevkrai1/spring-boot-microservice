package com.geo.test.task.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book extends Publication {
	private static final long serialVersionUID = 3758108863567540068L;
}
