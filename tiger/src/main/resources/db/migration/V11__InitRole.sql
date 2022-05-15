INSERT INTO role
(id_role, role_name)
SELECT 1, 'USER'
    WHERE
    NOT EXISTS (
        SELECT id_role FROM role WHERE id_role = 1
    );

INSERT INTO role
(id_role, role_name)
SELECT 2, 'ADMIN'
    WHERE
    NOT EXISTS (
        SELECT id_role FROM role WHERE id_role = 2
    );

INSERT INTO role
(id_role, role_name)
SELECT 3, 'MANAGER'
    WHERE
    NOT EXISTS (
        SELECT id_role FROM role WHERE id_role = 3
    );