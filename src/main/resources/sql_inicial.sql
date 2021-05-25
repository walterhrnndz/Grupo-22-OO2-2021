INSERT INTO `grupo-22-bdd-oo2-2021`.`user` (`id`, `enabled`, `password`, `username`) VALUES (1, b'1', '$2a$10$EZn2E9qBaDfuDayGyOCdkeE3SP5a.Cgs56dMm5Du2ocT3v5bM/TE6', 'admin');
INSERT INTO `grupo-22-bdd-oo2-2021`.`user_role` (`id`, `role`) VALUES (1, 'ROLE_ADMIN');
INSERT INTO `grupo-22-bdd-oo2-2021`.`user_role` (`id`, `role`) VALUES (2, 'ROLE_AUDITOR');
INSERT INTO `grupo-22-bdd-oo2-2021`.`user_to_role` (`user_id`, `role_id`) VALUES (1, 1);