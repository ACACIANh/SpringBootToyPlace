DROP TABLE IF EXISTS has_list;
CREATE TABLE `has_list` (
    `id`   bigint                       NOT NULL AUTO_INCREMENT COMMENT 'id',
    first  longtext collate utf8mb4_bin null comment 'first'
        check (json_valid(`first`)),
    second longtext collate utf8mb4_bin null comment 'second'
        check (json_valid(`second`)),
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `normal`;
CREATE TABLE `normal` (
    `id`   bigint                       NOT NULL AUTO_INCREMENT COMMENT 'id',
    first  longtext collate utf8mb4_bin null comment 'first'
        check (json_valid(`first`)),
    second longtext collate utf8mb4_bin null comment 'second'
        check (json_valid(`second`)),
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `jformat`;
CREATE TABLE `jformat` (
    `id`   bigint                       NOT NULL AUTO_INCREMENT COMMENT 'id',
    first  longtext collate utf8mb4_bin null comment 'first'
        check (json_valid(`first`)),
    second longtext collate utf8mb4_bin null comment 'second'
        check (json_valid(`second`)),
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `jout`;
CREATE TABLE `jout` (
    `id`  bigint                       NOT NULL AUTO_INCREMENT COMMENT 'id',
    first longtext collate utf8mb4_bin null comment 'first'
        check (json_valid(`first`)),
    PRIMARY KEY (`id`)
);
