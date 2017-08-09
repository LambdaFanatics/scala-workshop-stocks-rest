INSERT INTO users (id,name)
    VALUES
    (1, 'fp@someinc.com'),
    (2, 'gs@someinc.gr'),
    (3, 'iz@someinc.gr'),
    (4, 'gp@someinc.gr');

INSERT INTO stocks (code, description)
    VALUES
    ('FB', 'Facebook, Inc.'),
    ('GOOGL', 'Google, Inc.'),
    ('TSLA', 'Tesla, Inc.');

INSERT INTO users_stocks (user_id, stock_code)
    VALUES
    (1, 'FB'),
    (1, 'GOOGL'),
    (2, 'TSLA'),
    (2, 'FB'),
    (2, 'GOOGL'),
        -- 3 intentionally empty
    (4, 'FB');


