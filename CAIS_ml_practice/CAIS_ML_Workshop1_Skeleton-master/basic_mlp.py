import numpy as np
from sklearn import cross_validation

from keras.models import Sequential
from keras.layers import Dense

dataset = np.loadtxt('data/pima_indians_diabetes.csv', delimiter=',')

all_x = [point[0:8] for point in dataset]
all_y = [point[-1] for point in dataset]

all_x = np.array(all_x)
all_y = np.array(all_y)

x_train, x_test, y_train, y_test = cross_validation.train_test_split(all_x, all_y, test_size=0.2)
 
model = Sequential()
model.add(Dense(12, input_dim = 8, init = 'uniform', activation = 'relu'))
model.add(Dense(8,init = 'uniform', activation = 'relu'))
model.add(Dense(1, init = 'uniform', activation = 'sigmoid'))

model.compile(loss = 'binary_crossentropy', optimizer='SGD', metrics=['accuracy'])

model.fit(x_train, y_train, nb_epoch=150, batch_size=10, verbose=1)

scores = model.evaluate(x_test, y_test, verbose=1)

print 'Accuracy: %.2f' & (scores[1])