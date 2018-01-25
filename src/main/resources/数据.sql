/*
SQLyog Ultimate v11.13 (64 bit)
MySQL - 5.7.21 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

insert into `sys_role` (`id`, `name`) values('1','ROLE_ADMIN');
insert into `sys_role` (`id`, `name`) values('2','ROLE_USER');
insert into `sys_role` (`id`, `name`) values('3','ROLE_STU');


insert into `sys_user` (`id`, `password`, `username`) values('1','$2a$10$nFLTeGR0c8dx9/LHJwD6euJMG3O0M9EHJUGxMyAOWZ9Osntoj.v1G','a');
insert into `sys_user` (`id`, `password`, `username`) values('2','$2a$10$bx0blYXIAhqOrL744oakLulVFZ.XpfgntFoVcjY/lXBaPsZK/LHoS','b');
insert into `sys_user` (`id`, `password`, `username`) values('3','$2a$10$VdzOcG6pwW26Ox1ciB3RAuqvQ3ubgCNuX5djBN4o/RhxlmyZcgji6','c');


insert into `sys_user_roles` (`sys_user_id`, `roles_id`) values('2','2');
insert into `sys_user_roles` (`sys_user_id`, `roles_id`) values('1','1');
insert into `sys_user_roles` (`sys_user_id`, `roles_id`) values('3','3');
