CREATE TABLE `mydatabase`.`character` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `show` VARCHAR(45) NULL,
  `content` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

INSERT INTO `mydatabase`.`character`
VALUES (1, "Batman", "DC", "Batman is a superhero")
    	,(2, "Superman", "DC", "Batman is a superhero")
        ,(3, "Wonderwoman", "DC", "Batman is a superhero")
        ,(4, "Goku", "DragonBallz", "Batman is a superhero")
        ,(5, "Ironman", "MCU", "Batman is a superhero"); 

Select * From mydatabase.character;