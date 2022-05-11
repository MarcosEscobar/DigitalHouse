-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema DHTube
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema DHTube
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `DHTube` DEFAULT CHARACTER SET utf8 ;
USE `DHTube` ;

-- -----------------------------------------------------
-- Table `DHTube`.`COUNTRIES`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DHTube`.`COUNTRIES` (
  `country_id` INT NOT NULL AUTO_INCREMENT,
  `country_name` VARCHAR(45) NULL,
  PRIMARY KEY (`country_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DHTube`.`AVATAR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DHTube`.`AVATAR` (
  `avatar_id` INT NOT NULL AUTO_INCREMENT,
  `avatar_name` VARCHAR(45) NOT NULL,
  `avatar_url` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`avatar_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DHTube`.`USER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DHTube`.`USER` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NULL,
  `password` VARCHAR(32) NOT NULL,
  `user_born_date` DATE NOT NULL,
  `user_country` INT NULL,
  `user_zip_code` VARCHAR(10) NULL,
  `user_avatar_id` INT NOT NULL,
  PRIMARY KEY (`user_id`),
  INDEX `fk_user_country_idx` (`user_country` ASC) VISIBLE,
  INDEX `fk_user_avatar_id_idx` (`user_avatar_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_country`
    FOREIGN KEY (`user_country`)
    REFERENCES `DHTube`.`COUNTRIES` (`country_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_avatar_id`
    FOREIGN KEY (`user_avatar_id`)
    REFERENCES `DHTube`.`AVATAR` (`avatar_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `DHTube`.`PLAYLIST`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DHTube`.`PLAYLIST` (
  `playlist_id` INT NOT NULL AUTO_INCREMENT,
  `playlist_name` VARCHAR(45) NOT NULL,
  `playlist_creation_date` DATE NOT NULL,
  `playlist_user_id` INT NOT NULL,
  `playlist_privacy_status` BINARY NOT NULL,
  PRIMARY KEY (`playlist_id`),
  INDEX `playlist_user_id_idx` (`playlist_user_id` ASC) VISIBLE,
  CONSTRAINT `playlist_user_id`
    FOREIGN KEY (`playlist_user_id`)
    REFERENCES `DHTube`.`USER` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DHTube`.`LABEL`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DHTube`.`LABEL` (
  `label_id` INT NOT NULL AUTO_INCREMENT,
  `label_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`label_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DHTube`.`VIDEOS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DHTube`.`VIDEOS` (
  `video_id` INT NOT NULL AUTO_INCREMENT,
  `video_title` VARCHAR(45) NOT NULL,
  `video_description` VARCHAR(45) NOT NULL,
  `video_size` INT NOT NULL,
  `vide_file_name` VARCHAR(45) NOT NULL,
  `video_lenght` TIME NOT NULL,
  `video_img_url` VARCHAR(45) NOT NULL,
  `video_play_count` INT NOT NULL,
  `video_like_count` INT NOT NULL,
  `video_dislike_count` INT NOT NULL,
  `video_reactions` INT NOT NULL,
  `video_user_id` INT NULL,
  `video_privacy_status` BINARY NULL,
  `video_labels_id` INT NULL,
  `video_timestamp` DATETIME NULL,
  PRIMARY KEY (`video_id`),
  INDEX `fk_user_id_idx` (`video_user_id` ASC) VISIBLE,
  INDEX `fk_label_id_idx` (`video_labels_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_id`
    FOREIGN KEY (`video_user_id`)
    REFERENCES `DHTube`.`USER` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_label_id`
    FOREIGN KEY (`video_labels_id`)
    REFERENCES `DHTube`.`LABEL` (`label_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DHTube`.`PLAYLIST_VIDEO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DHTube`.`PLAYLIST_VIDEO` (
  `playlist_video_id` INT NOT NULL AUTO_INCREMENT,
  `playlist_video_video_id` INT NOT NULL,
  `playlist_video_playlist_id` INT NOT NULL,
  INDEX `fk_playlist_id_idx` (`playlist_video_playlist_id` ASC) VISIBLE,
  INDEX `fk_playlist_video_video_id_idx` (`playlist_video_video_id` ASC) VISIBLE,
  PRIMARY KEY (`playlist_video_id`),
  CONSTRAINT `fk_playlist_video_playlist_id`
    FOREIGN KEY (`playlist_video_playlist_id`)
    REFERENCES `DHTube`.`PLAYLIST` (`playlist_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_playlist_video_video_id`
    FOREIGN KEY (`playlist_video_video_id`)
    REFERENCES `DHTube`.`VIDEOS` (`video_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DHTube`.`REACTIONS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DHTube`.`REACTIONS` (
  `reaction_id` INT NOT NULL AUTO_INCREMENT,
  `reaction_name` VARCHAR(45) NOT NULL,
  `reaction_icon_url` VARCHAR(45) NULL,
  PRIMARY KEY (`reaction_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DHTube`.`USER_REACTIONS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DHTube`.`USER_REACTIONS` (
  `user_reaction_id` INT NOT NULL AUTO_INCREMENT,
  `user_reaction_user_id` INT NULL,
  `user_reaction_reaction_id` INT NULL,
  `user_reaction_video_id` INT NULL,
  `user_reaction_time` DATETIME NULL,
  PRIMARY KEY (`user_reaction_id`),
  INDEX `fk_user_id_idx` (`user_reaction_reaction_id` ASC) VISIBLE,
  INDEX `fk_video_id_idx` (`user_reaction_video_id` ASC) VISIBLE,
  CONSTRAINT `fk_userreactions_user_id`
    FOREIGN KEY (`user_reaction_reaction_id`)
    REFERENCES `DHTube`.`USER` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reaction_id`
    FOREIGN KEY (`user_reaction_reaction_id`)
    REFERENCES `DHTube`.`REACTIONS` (`reaction_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_video_id`
    FOREIGN KEY (`user_reaction_video_id`)
    REFERENCES `DHTube`.`VIDEOS` (`video_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DHTube`.`CHANNELS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DHTube`.`CHANNELS` (
  `channel_id` INT NOT NULL,
  `channel_name` VARCHAR(45) NOT NULL,
  `channel_user_id` INT NOT NULL,
  `channel_description` VARCHAR(45) NOT NULL,
  `channel_creation_date` DATE NOT NULL,
  PRIMARY KEY (`channel_id`),
  INDEX `fk_channel_user_id_idx` (`channel_user_id` ASC) VISIBLE,
  CONSTRAINT `fk_channel_user_id`
    FOREIGN KEY (`channel_user_id`)
    REFERENCES `DHTube`.`USER` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
