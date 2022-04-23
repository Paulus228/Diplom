INSERT INTO role
(user_id, role_name)
SELECT 1, 'USER'
    WHERE
    NOT EXISTS (
            SELECT user_id FROM role WHERE user_id = 1
        );

INSERT INTO role
(user_id, role_name)
SELECT 2, 'ADMIN'
    WHERE
    NOT EXISTS (
            SELECT user_id FROM role WHERE user_id = 2
        );