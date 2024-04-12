CREATE TABLE transactions_pins (
    id BIGINT NOT NULL AUTO_INCREMENT,
    pin VARCHAR(50) NOT NULL,
    attempt INT NOT NULL,
    blocked Bool NOT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME,
    PRIMARY KEY (id)
);
