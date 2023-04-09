-- Заповнення таблиці "Client" 10 випадковими записами
INSERT INTO Client (name)
values
('Max'),
('Anna'),
('Olga'),
('Oleg'),
('Anton'),
('Valera'),
('Darya'),
('Victorya'),
('Grisha'),
('Anastasiya');


-- Заповнення таблиці "Planet" 5 випадковими записами
INSERT INTO Planet (id, name)
values
('UID7', 'Solar'),
('KLO1', 'Morad'),
('VHI12', 'Andromeda'),
('HID2', 'Kripton'),
('UUI17', 'Ra');

-- Заповнення таблиці "Ticket" 20 випадковими записами
INSERT INTO ticket (created_at, client_id, from_planet_id, to_planet_id)
SELECT
    NOW() - INTERVAL '1 day' * (random() * 30 + 1),
    c.id,
    p1.id,
    p2.id
FROM
    client c
    CROSS JOIN planet p1
    CROSS JOIN planet p2
WHERE
    p1.id <> p2.id
ORDER BY
    random()
LIMIT
    10;

