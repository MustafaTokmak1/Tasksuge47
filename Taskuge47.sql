#1. Queries in MySQL Workbench.
USE sakila;
SELECT * FROM actor;
SELECT * FROM actor WHERE last_name = "CAGE";
SELECT * FROM actor WHERE NOT first_name = "ZERO" AND NOT first_name = "NICK";
SELECT * FROM actor WHERE first_name IN ('NICK', 'JAMES','Johnny','MORGAN','WHOOPI');
SELECT * FROM actor WHERE actor_id >49 AND actor_id<151;
SELECT * FROM actor WHERE first_name LIKE "C%";
SELECT * FROM actor ORDER BY first_name;
SELECT * FROM actor ORDER BY last_name DESC;
SELECT COUNT(actor_id) FROM actor;
SELECT COUNT(DISTINCT first_name) FROM actor;
SELECT * FROM film_category WHERE category_id = 11;

#2 More queries
INSERT INTO actor(first_name, last_name)
VALUES('Mustafa','Tokmak');

INSERT INTO film_actor(actor_id, film_id)
VALUES('39','123'),('36','321'),('22','523'),('21','873'),('20','291');
UPDATE actor SET first_name = "Mufasa", last_name = "Tomako"
WHERE actor_id = 201;
SET foreign_key_checks=0;
DELETE from actor WHERE actor_id = 201;
SET foreign_key_checks=1;

#3 JOINS
SELECT * FROM category;
SELECT * FROM film_category where category_id = "11";
SELECT * FROM film INNER JOIN film_category ON film_category.film_id = film.film_id WHERE film_category.category_id = "11";