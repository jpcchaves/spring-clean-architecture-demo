CREATE TABLE wallets (
    id BIGINT NOT NULL AUTO_INCREMENT,
    balance DECIMAL(10, 2) NOT NULL,
    user_id UUID NOT NULL,
    transaction_pin_id BIGINT NOT NULL,

    PRIMARY KEY (id),

    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (transaction_pin_id) REFERENCES transactions_pins(id)
);
