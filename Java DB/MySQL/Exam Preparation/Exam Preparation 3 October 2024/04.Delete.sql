SET FOREIGN_KEY_CHECKS = 0;

DELETE FROM preserves
WHERE established_on IS NULL;

SET FOREIGN_KEY_CHECKS = 1;