INSERT INTO `tpoo2`.`user` (`id`, `enabled`, `password`, `username`)
VALUES ('1', b'1', '$2a$10$EZn2E9qBaDfuDayGyOCdkeE3SP5a.Cgs56dMm5Du2ocT3v5bM/TE6', 'admin');

INSERT INTO `tpoo2`.`user_role` (`id`, `role`, `user_id`) VALUES ('1', 'ADMIN', '1');