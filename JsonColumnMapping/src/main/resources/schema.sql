DROP TABLE IF EXISTS has_list;
-- CREATE TABLE `has_list`
-- (
--     `id`         bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
--     field_first  longtext collate utf8mb4_bin null comment 'first'
--         check (json_valid(`azure_roles`)),
--     field_second longtext collate utf8mb4_bin null comment 'second'
--         check (json_valid(`azure_groups`)),
--     PRIMARY KEY (`id`)
-- )