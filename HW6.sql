-- В рамках БД "песочница: интернет-магазин" напишите след/запросы:
-- 1. Вывести ко-во поставщиков не из UK и не из China
SELECT count(*) 
FROM Suppliers
WHERE Country NOT IN ('UK', 'China');

-- 2. Вывести среднюю/MAX/MIN стоимости и ко-во товаров из категорий 3 и 5
SELECT avg (Price),
	max(Price),
    min(Price),
    count(distinct ProductName) AS product_from_3_and_5_category
FROM Products
WHERE CategoryID IN (3,5);

-- 3. Вывести общую сумму проданных товаров
SELECT  
	SUM (Products.Price * OrderDetails.Quantity) AS SUM_sold_products
FROM OrderDetails
JOIN Products ON OrderDetails.ProductID=Products.ProductID;

-- 4. Вывести ко-во стран, которые поставляют напитки
select COUNT(distinct Country) AS total_country_selling_Beverages
from products
join categories on products.CategoryID=categories.CategoryID
join Suppliers on products.SupplierID=Suppliers.SupplierID
where categories.CategoryName = 'Beverages';

-- 5. Вывести сумму, на которую было отправлено товаров клиентам в USA
SELECT SUM (Products.Price * OrderDetails.Quantity) AS SUM_sold_products_USA
FROM Orders
JOIN Customers ON Orders.CustomerID=Customers.CustomerID
JOIN OrderDetails ON Orders.OrderID=OrderDetails.OrderID
JOIN products ON products.ProductID=OrderDetails.ProductID
WHERE Country = 'USA';