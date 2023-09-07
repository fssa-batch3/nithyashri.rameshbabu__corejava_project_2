-- ----------------------------------------------------------------------------
-- MySQL Workbench Migration
-- Migrated Schemata: nithyashri_rameshbabu_corejava_project
-- Source Schemata: nithyashri_rameshbabu_corejava_project
-- Created: Tue Sep  5 11:21:33 2023
-- Workbench Version: 8.0.32
-- ----------------------------------------------------------------------------

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------------------------------------------------------
-- Schema nithyashri_rameshbabu_corejava_project
-- ----------------------------------------------------------------------------
DROP SCHEMA IF EXISTS `nithyashri_rameshbabu_corejava_project` ;
CREATE SCHEMA IF NOT EXISTS `nithyashri_rameshbabu_corejava_project` ;

-- ----------------------------------------------------------------------------
-- Table nithyashri_rameshbabu_corejava_project.appointments
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `nithyashri_rameshbabu_corejava_project`.`appointments` (
  `doctor_name` VARCHAR(50) NOT NULL,
  `appointment_time` DATETIME NOT NULL,
  `app_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `hospital_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`app_id`),
  INDEX `fk_user_user_id` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `nithyashri_rameshbabu_corejava_project`.`user` (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 23
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------------------------------------------------------
-- Table nithyashri_rameshbabu_corejava_project.user
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `nithyashri_rameshbabu_corejava_project`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 15
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
SET FOREIGN_KEY_CHECKS = 1;
