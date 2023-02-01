-- Franchises
INSERT INTO franchise ("description", "name") VALUES ('Tenet Stuff', 'Tenet Franchise');
INSERT INTO franchise ("description", "name") VALUES ('Floklipa crazyness', 'Floklipa Franchise');
INSERT INTO franchise ("description", "name") VALUES ('Wizard School', 'Harry Potter Franchise');
INSERT INTO franchise ("description", "name") VALUES ('Odd Martins favorites', 'Odd Animes Franchise');

-- Movies
INSERT INTO movies ("director", "genre", "picture", "release_year", "title", "trailer", "franchise_id") VALUES ('Christopher Nolan', 'Sci-fi', 'tenet_image_url', 2020, 'Tenet', 'youtube.com/tenet', 1);
INSERT INTO movies ("director", "genre", "picture", "release_year", "title", "trailer", "franchise_id") VALUES ('Ivo Kaprino', 'Komedie', 'Floklipa_image_url', 1975, 'Floklipa Granprix', 'youtube.com/floklipa', 2);
INSERT INTO movies ("director", "genre", "picture", "release_year", "title", "trailer", "franchise_id") VALUES ('Chris Columbus', 'Fantasy', 'harrypotter_image_url', 2001, 'Harry Potter Nr 1','youtube.com/harry1', 3);
INSERT INTO movies ("director", "genre", "picture", "release_year", "title", "trailer", "franchise_id") VALUES ('Chris Columbus', 'Fantasy', 'harrypotter2_image_url', 2003, 'Harry Potter Nr 2','youtube.com/harry2', 3);
INSERT INTO movies ("director", "genre", "picture", "release_year", "title", "trailer", "franchise_id") VALUES ('Atsuko Ishizuka', 'Fantasy', 'nogamenolife_image_url', 2017, 'No Game No Life','youtube.com/nogamenolife', 4);
INSERT INTO movies ("director", "genre", "picture", "release_year", "title", "trailer", "franchise_id") VALUES ('Atsuko Ishizuka', 'Fantasy', 'nogamenolife_zero_image_url', 2017, 'No Game No Life: Zero','youtube.com/nogamenolifezero', 4);

-- Characters
INSERT INTO character ("alias", "full_name", "gender", "picture") VALUES ('Harry Potter', 'Daniel Radcliffe', 'male', 'daniel_picture');
INSERT INTO character ("alias", "full_name", "gender", "picture") VALUES ('Solan Gundersen', 'en fugl', 'male', 'solan_gundy_image');
INSERT INTO character ("alias", "full_name", "gender", "picture") VALUES ('Sora', 'Blank', 'male', 'sora_image');
INSERT INTO character ("alias", "full_name", "gender", "picture") VALUES ('Shiro', 'Blank', 'female', 'shiro_image');

-- Characters in Movies Linked Table
INSERT INTO movies_characters ("movies_id", "character_id") VALUES (3,1);
INSERT INTO movies_characters ("movies_id", "character_id") VALUES (2,2);
INSERT INTO movies_characters ("movies_id", "character_id") VALUES (4,1);
INSERT INTO movies_characters ("movies_id", "character_id") VALUES (5,3);
INSERT INTO movies_characters ("movies_id", "character_id") VALUES (5,4);
INSERT INTO movies_characters ("movies_id", "character_id") VALUES (6,3);
INSERT INTO movies_characters ("movies_id", "character_id") VALUES (6,4);