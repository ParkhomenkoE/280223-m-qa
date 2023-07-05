--  1 уровень сложности: 
-- В рамках БД "песочница" напишите след/запросы:

-- Вывести информацию о трех самых дорогих товарах не из China 
-- (проекция: название товара, цена товара в usd, название поставщика, страна поставщика)
SELECT  Products.ProductName,
    	ROUND (Products.Price*.92, 2) AS Price_USD,
    	Suppliers.SupplierName,
        Country
FROM Products inner Join Suppliers USING(SupplierID)
Where Country != 'China'
Order by Price_USD Desc
Limit 3;

-- Вывести страны клиентов и поставщиков (за исключением USA)
select distinct
Country
from suppliers, customers
where suppliers.Country <> 'USA';

-- Вывести названия проданных товаров
SELECT DISTINCT ProductName 
FROM OrderDetails
  inner join Products using(ProductID);

-- В рамках БД "стриминг-платформа":
-- С помощью DDL создайте таблицу "комментарии юзеров к видео"
CREATE TABLE comments (
    comment_id int,
    content varchar(256),
    stream_id int,
    user_id int,
    created_at timestamp
);

-- Вывести три последних комментария, включая имена авторов и названия видео
select content, username, title  
from comments
	join users using(user_id)
    join streams using(stream_id)
order by created_at desc
limit 3;

