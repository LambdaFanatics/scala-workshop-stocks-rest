INSERT INTO users (id,name)
    VALUES
    (1, 'fpas@accepted.gr'),
    (2, 'smyrn@accepted.gr'),
    (3, 'iroza@accepted.gr'),
    (4, 'gpapag@accepted.gr');

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


