-- В рамках БД "песочница: интернет-магазин" напишите след/запросы:
-- Найти мин/стоимость товаров для каждой категории
SELECT CategoryID,
MIN(Price) AS min_price
FROM Products
GROUP BY CategoryID;

-- Вывести ТОП-3 стран по количеству доставленных заказов

SELECT country, COUNT(*)
FROM Orders inner join customers using(customerId)
group by country
order by COUNT(*) desc
limit 3;

-- Вывести названия категорий, в которых более 10 товаров
SELECT categoryName
FROM products inner join categories using(categoryId)
group by categoryId, categoryName
having COUNT(*) > 10;

-- Очистить тел/номер поставщикам из USA
UPDATE Suppliers
SET Phone='null'
WHERE
	Country='USA'; 
    
-- Вывести имена и фамилии (и ко-во заказов) менеджеров, у которых ко-во заказов менее 15
SELECT LastName, FirstName,
COUNT(*) as total_orders
FROM orders  
inner join Employees USING(EmployeeID)
group by EmployeeID, LastName, FirstName
having total_orders < 15;