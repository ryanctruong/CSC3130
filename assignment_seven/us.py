import pandas as pd
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split
from sklearn.metrics import mean_squared_error

# Load the dataset
data = pd.read_csv('us.csv')

# Split the data into input (X) and output (y) variables
X = data['Sales'].values.reshape(-1, 1)
y = data['Store Size'].values

# Split the data into training and testing sets
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# Create a linear regression model
model = LinearRegression()

# Train the model
model.fit(X_train, y_train)

# Make predictions on the test set
y_pred = model.predict(X_test)

# Evaluate the model using mean squared error
mse = mean_squared_error(y_test, y_pred)
print(f"Mean Squared Error: {mse}")

# Predict the sales of a new store
new_store_size = 20000
new_store_sales = model.predict([[new_store_size]])
print(f"Predicted sales for a new store with size {new_store_size}: {new_store_sales[0]}")
