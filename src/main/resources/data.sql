-- city table data
INSERT INTO CITY (ID, NAME, STATE, ZIP_CODE)
VALUES ('1', 'Kathmandu', 'Province 3', '44600') ON CONFLICT DO NOTHING;
INSERT INTO CITY (ID, NAME, STATE, ZIP_CODE)
VALUES ('2', 'Pokhara', 'Province 4', '33700') ON CONFLICT DO NOTHING;
INSERT INTO CITY (ID, NAME, STATE, ZIP_CODE)
VALUES ('3', 'Biratnagar', 'Province 1', '56613') ON CONFLICT DO NOTHING;
INSERT INTO CITY (ID, NAME, STATE, ZIP_CODE)
VALUES ('4', 'Birgunj', 'Province 2', '44300') ON CONFLICT DO NOTHING;
INSERT INTO CITY (ID, NAME, STATE, ZIP_CODE)
VALUES ('5', 'Dharan', 'Province 1', '56700') ON CONFLICT DO NOTHING;
INSERT INTO CITY (ID, NAME, STATE, ZIP_CODE)
VALUES ('6', 'Bharatpur', 'Province 3', '44200') ON CONFLICT DO NOTHING;
INSERT INTO CITY (ID, NAME, STATE, ZIP_CODE)
VALUES ('7', 'Janakpur', 'Province 2', '45600') ON CONFLICT DO NOTHING;
INSERT INTO CITY (ID, NAME, STATE, ZIP_CODE)
VALUES ('8', 'Hetauda', 'Province 3', '44100') ON CONFLICT DO NOTHING;
INSERT INTO CITY (ID, NAME, STATE, ZIP_CODE)
VALUES ('9', 'Butwal', 'Province 5', '32907') ON CONFLICT DO NOTHING;
INSERT INTO CITY (ID, NAME, STATE, ZIP_CODE)
VALUES ('10', 'Bhaktapur', 'Province 3', '44800') ON CONFLICT DO NOTHING;
INSERT INTO CITY (ID, NAME, STATE, ZIP_CODE)
VALUES ('11', 'Dhangadhi', 'Province 7', '10900') ON CONFLICT DO NOTHING;
INSERT INTO CITY (ID, NAME, STATE, ZIP_CODE)
VALUES ('12', 'Itahari', 'Province 1', '56600') ON CONFLICT DO NOTHING;
INSERT INTO CITY (ID, NAME, STATE, ZIP_CODE)
VALUES ('13', 'Nepalgunj', 'Province 5', '21900') ON CONFLICT DO NOTHING;
INSERT INTO CITY (ID, NAME, STATE, ZIP_CODE)
VALUES ('14', 'Dhulikhel', 'Province 3', '45200') ON CONFLICT DO NOTHING;
INSERT INTO CITY (ID, NAME, STATE, ZIP_CODE)
VALUES ('15', 'Dipayal', 'Province 7', '10900') ON CONFLICT DO NOTHING;
INSERT INTO CITY (ID, NAME, STATE, ZIP_CODE)
VALUES ('16', 'Dadeldhura', 'Province 7', '10900') ON CONFLICT DO NOTHING;
INSERT INTO CITY (ID, NAME, STATE, ZIP_CODE)
VALUES ('17', 'Darchula', 'Province 7', '10900') ON CONFLICT DO NOTHING;
INSERT INTO CITY (ID, NAME, STATE, ZIP_CODE)
VALUES ('18', 'Dailekh', 'Province 6', '10900') ON CONFLICT DO NOTHING;
INSERT INTO CITY (ID, NAME, STATE, ZIP_CODE)
VALUES ('19', 'Dang', 'Province 5', '10900') ON CONFLICT DO NOTHING;
INSERT INTO CITY (ID, NAME, STATE, ZIP_CODE)
VALUES ('20', 'Dhading', 'Province 3', '10900') ON CONFLICT DO NOTHING;

-- cinema table data
INSERT INTO CINEMA (ID, NAME, TOTAL_CINEMA_HALLS, CITY_ID)
VALUES ('1', 'QFX Cinemas', '5', '1') ON CONFLICT DO NOTHING;
INSERT INTO CINEMA (ID, NAME, TOTAL_CINEMA_HALLS, CITY_ID)
VALUES ('2', 'Big Movies', '3', '1') ON CONFLICT DO NOTHING;
INSERT INTO CINEMA (ID, NAME, TOTAL_CINEMA_HALLS, CITY_ID)
VALUES ('3', 'FCube Cinemas', '4', '1') ON CONFLICT DO NOTHING;
INSERT INTO CINEMA (ID, NAME, TOTAL_CINEMA_HALLS, CITY_ID)
VALUES ('4', 'QFX Cinemas', '5', '2') ON CONFLICT DO NOTHING;
INSERT INTO CINEMA (ID, NAME, TOTAL_CINEMA_HALLS, CITY_ID)
VALUES ('5', 'Big Movies', '3', '2') ON CONFLICT DO NOTHING;
INSERT INTO CINEMA (ID, NAME, TOTAL_CINEMA_HALLS, CITY_ID)
VALUES ('6', 'FCube Cinemas', '4', '2') ON CONFLICT DO NOTHING;
INSERT INTO CINEMA (ID, NAME, TOTAL_CINEMA_HALLS, CITY_ID)
VALUES ('7', 'QFX Cinemas', '5', '3') ON CONFLICT DO NOTHING;
INSERT INTO CINEMA (ID, NAME, TOTAL_CINEMA_HALLS, CITY_ID)
VALUES ('8', 'Big Movies', '3', '3') ON CONFLICT DO NOTHING;
INSERT INTO CINEMA (ID, NAME, TOTAL_CINEMA_HALLS, CITY_ID)
VALUES ('9', 'FCube Cinemas', '4', '3') ON CONFLICT DO NOTHING;
INSERT INTO CINEMA (ID, NAME, TOTAL_CINEMA_HALLS, CITY_ID)
VALUES ('10', 'QFX Cinemas', '5', '4') ON CONFLICT DO NOTHING;
INSERT INTO CINEMA (ID, NAME, TOTAL_CINEMA_HALLS, CITY_ID)
VALUES ('11', 'Big Movies', '3', '4') ON CONFLICT DO NOTHING;
INSERT INTO CINEMA (ID, NAME, TOTAL_CINEMA_HALLS, CITY_ID)
VALUES ('12', 'FCube Cinemas', '4', '4') ON CONFLICT DO NOTHING;
INSERT INTO CINEMA (ID, NAME, TOTAL_CINEMA_HALLS, CITY_ID)
VALUES ('13', 'QFX Cinemas', '5', '5') ON CONFLICT DO NOTHING;
INSERT INTO CINEMA (ID, NAME, TOTAL_CINEMA_HALLS, CITY_ID)
VALUES ('14', 'Big Movies', '3', '5') ON CONFLICT DO NOTHING;
INSERT INTO CINEMA (ID, NAME, TOTAL_CINEMA_HALLS, CITY_ID)
VALUES ('15', 'FCube Cinemas', '4', '5') ON CONFLICT DO NOTHING;
INSERT INTO CINEMA (ID, NAME, TOTAL_CINEMA_HALLS, CITY_ID)
VALUES ('16', 'QFX Cinemas', '5', '6') ON CONFLICT DO NOTHING;
INSERT INTO CINEMA (ID, NAME, TOTAL_CINEMA_HALLS, CITY_ID)
VALUES ('17', 'Big Movies', '3', '6') ON CONFLICT DO NOTHING;
INSERT INTO CINEMA (ID, NAME, TOTAL_CINEMA_HALLS, CITY_ID)
VALUES ('18', 'FCube Cinemas', '4', '6') ON CONFLICT DO NOTHING;
INSERT INTO CINEMA (ID, NAME, TOTAL_CINEMA_HALLS, CITY_ID)
VALUES ('19', 'QFX Cinemas', '5', '7') ON CONFLICT DO NOTHING;
INSERT INTO CINEMA (ID, NAME, TOTAL_CINEMA_HALLS, CITY_ID)
VALUES ('20', 'Big Movies', '3', '7') ON CONFLICT DO NOTHING;

-- cinema_hall table data
INSERT INTO CINEMA_HALL (ID, NAME, TOTAL_SEATS, CINEMA_ID)
VALUES ('1', 'Gopi Krishna', '100', '1') ON CONFLICT DO NOTHING;
INSERT INTO CINEMA_HALL (ID, NAME, TOTAL_SEATS, CINEMA_ID)
VALUES ('2', 'City Center', '100', '1') ON CONFLICT DO NOTHING;
INSERT INTO CINEMA_HALL (ID, NAME, TOTAL_SEATS, CINEMA_ID)
VALUES ('3', 'Kumari', '100', '1') ON CONFLICT DO NOTHING;
INSERT INTO CINEMA_HALL (ID, NAME, TOTAL_SEATS, CINEMA_ID)
VALUES ('4', 'Kumari', '100', '2') ON CONFLICT DO NOTHING;
INSERT INTO CINEMA_HALL (ID, NAME, TOTAL_SEATS, CINEMA_ID)
VALUES ('5', 'City Center', '100', '2') ON CONFLICT DO NOTHING;
INSERT INTO CINEMA_HALL (ID, NAME, TOTAL_SEATS, CINEMA_ID)
VALUES ('6', 'Gopi Krishna', '100', '2') ON CONFLICT DO NOTHING;
INSERT INTO CINEMA_HALL (ID, NAME, TOTAL_SEATS, CINEMA_ID)
VALUES ('7', 'Kumari', '100', '3') ON CONFLICT DO NOTHING;
INSERT INTO CINEMA_HALL (ID, NAME, TOTAL_SEATS, CINEMA_ID)
VALUES ('8', 'City Center', '100', '3') ON CONFLICT DO NOTHING;
INSERT INTO CINEMA_HALL (ID, NAME, TOTAL_SEATS, CINEMA_ID)
VALUES ('9', 'Gopi Krishna', '100', '3') ON CONFLICT DO NOTHING;
INSERT INTO CINEMA_HALL (ID, NAME, TOTAL_SEATS, CINEMA_ID)
VALUES ('10', 'KL Tower', '100', '4') ON CONFLICT DO NOTHING;
INSERT INTO CINEMA_HALL (ID, NAME, TOTAL_SEATS, CINEMA_ID)
VALUES ('11', 'QFX Kumari', '100', '4') ON CONFLICT DO NOTHING;
INSERT INTO CINEMA_HALL (ID, NAME, TOTAL_SEATS, CINEMA_ID)
VALUES ('12', 'QFX Gopi Krishna', '100', '4') ON CONFLICT DO NOTHING;
INSERT INTO CINEMA_HALL (ID, NAME, TOTAL_SEATS, CINEMA_ID)
VALUES ('13', 'QFX Kumari', '100', '5') ON CONFLICT DO NOTHING;
INSERT INTO CINEMA_HALL (ID, NAME, TOTAL_SEATS, CINEMA_ID)
VALUES ('14', 'KL Tower', '100', '5') ON CONFLICT DO NOTHING;
INSERT INTO CINEMA_HALL (ID, NAME, TOTAL_SEATS, CINEMA_ID)
VALUES ('15', 'QFX Gopi Krishna', '100', '5') ON CONFLICT DO NOTHING;
INSERT INTO CINEMA_HALL (ID, NAME, TOTAL_SEATS, CINEMA_ID)
VALUES ('16', 'QFX Kumari', '100', '6') ON CONFLICT DO NOTHING;
INSERT INTO CINEMA_HALL (ID, NAME, TOTAL_SEATS, CINEMA_ID)
VALUES ('17', 'KL Tower', '100', '6') ON CONFLICT DO NOTHING;
INSERT INTO CINEMA_HALL (ID, NAME, TOTAL_SEATS, CINEMA_ID)
VALUES ('18', 'QFX Gopi Krishna', '100', '6') ON CONFLICT DO NOTHING;
INSERT INTO CINEMA_HALL (ID, NAME, TOTAL_SEATS, CINEMA_ID)
VALUES ('19', 'QFX Kumari', '100', '7') ON CONFLICT DO NOTHING;
INSERT INTO CINEMA_HALL (ID, NAME, TOTAL_SEATS, CINEMA_ID)
VALUES ('20', 'KL Tower', '100', '7') ON CONFLICT DO NOTHING;

-- movie table data
INSERT INTO MOVIE (ID, TITLE, DESCRIPTION, DURATION, LANGUAGE, RELEASE_DATE, COUNTRY, GENRE)
VALUES ('12345', 'The Shawshank Redemption',
        'Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.',
        '1994-09-23', 'English', '1994-09-23', 'United States', 'Drama') ON CONFLICT DO NOTHING;


-- show table data

-- customer table data
INSERT INTO CUSTOMER (ID, USERNAME, EMAIL, PHONE)
VALUES ('1', 'sajankc', 'sajan@gmail.com', '9841000000') ON CONFLICT DO NOTHING;
INSERT INTO CUSTOMER (ID, USERNAME, EMAIL, PHONE)
VALUES ('2', 'jane', 'jane@gmail.com', '9841000001') ON CONFLICT DO NOTHING;
INSERT INTO CUSTOMER (ID, USERNAME, EMAIL, PHONE)
VALUES ('3', 'joe', 'joe@gmail.com', '9841000002') ON CONFLICT DO NOTHING;
INSERT INTO CUSTOMER (ID, USERNAME, EMAIL, PHONE)
VALUES ('4', 'jim', 'jim@gmail.com', '9841000003') ON CONFLICT DO NOTHING;