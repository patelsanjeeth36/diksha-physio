CREATE TABLE callback_requests (
    id            BIGSERIAL PRIMARY KEY,
    name          VARCHAR(100)  NOT NULL,
    phone         VARCHAR(20)   NOT NULL,
    message       TEXT,
    preferred_time VARCHAR(100),
    status        VARCHAR(20)   NOT NULL DEFAULT 'PENDING',
    created_at    TIMESTAMP     NOT NULL DEFAULT NOW()
);

CREATE INDEX idx_callback_requests_status ON callback_requests(status);
CREATE INDEX idx_callback_requests_created_at ON callback_requests(created_at DESC);
