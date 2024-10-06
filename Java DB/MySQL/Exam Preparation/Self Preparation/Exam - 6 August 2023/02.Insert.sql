INSERT INTO property_transactions (
property_id, buyer_id, transaction_date, bank_name, iban, is_successful)
SELECT agent_id + DAY(offer_datetime), 
	agent_id + MONTH(offer_datetime), 
    offer_datetime,
    CONCAT_WS(' ', 'Bank', agent_id),
    CONCAT('BG', price, agent_id),
    1
FROM property_offers
WHERE agent_id <= 2;

