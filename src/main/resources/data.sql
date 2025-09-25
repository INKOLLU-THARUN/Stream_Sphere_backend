-- Sample movie data for testing
INSERT INTO movies (title, thumbnail, video_url) VALUES 
('MARCO (API)', '/thumbnails/1738472442795_MARCO-Gun_2feb_landscape_thumb.jpg', '/movies/MARCO.mp4'),
('MAHAAN (API)', '/thumbnails/mahaan-movie-review-1.jpg', '/movies/MAHAAN.mp4'),
('SARIPODAA SANIVAARAM (API)', '/thumbnails/Saripodhaa-Sanivaaram-first-show.jpg', '/movies/SARIPODHAA SANIVAARAM.mp4'),
('GREATEST OF ALL TIME (API)', '/thumbnails/goat-vijay-1600.avif', '/movies/GOAT.mp4');

-- Sample TV shows data
INSERT INTO tv_shows (title, thumbnail, video_url) VALUES
('90s Middle Class Biopic', '/thumbnails/90-s.png', '/Shows/90''s middie class biopic.mp4'),
('Agent Anand Santosh', '/thumbnails/AAS.jpg', '/Shows/Agent Anand Santosh Trailer _ Shanmukh Jaswanth _ Infinitum Media _ Arun Pawar _ ahaVideoIN.mp4'),
('Save the Tigers', '/thumbnails/SAVE THE TIGERS.webp', '/Shows/save the tigers.mp4'),
('Student', '/thumbnails/STUDENT.jpg', '/Shows/student.mp4');

-- Sample users for authentication (with proper BCrypt hashes)
INSERT INTO users (email, password) VALUES
('raghavendrakumar478@gmail.com', '$2a$10$N8pZvY2IgJcF4eE6QpYOV.xR1rjD9iF.gH4Jz3UeM9v1dK4fO6n3K'),
('tharun.inkollu2005@gmail.com', '$2a$10$K2rI8tW9uV6gX2pR7fY8q.5B9hE7rQ1gL6mP9vN4cW3pV8eT4dK8M');