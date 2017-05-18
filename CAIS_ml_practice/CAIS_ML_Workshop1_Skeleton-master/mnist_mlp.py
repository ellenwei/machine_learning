import numpy as np
from keras.datasets import mnist
from keras.models import Sequential
from keras.layers.core import Dense, Dropout, Activation
from keras.optimizers import RMSprop
from keras.utils import np_utils
from helper.plot_helper import *


(all_train_x, all_train_y), (all_test_x, all_test_y) = mnist.load_data()

train_shape = all_train_x.shape
test_shape = all_test_x.shape

all_train_x = all_train_x.reshape(train_shape[0], train_shape[1]*train_shape[2])

all_test_x = all_test_x.reshape(test_shape[0], test_shape[1]*test_shape[2])

all_train_x = all_train_x.astype('float32')
all_test_x = all_test_x.astype('float32')

all_train_x = all_train_x/255
all_test_x /= 255

all_train_y = np_utils.to_categorical(all_train_y, class_count)
all_test_y = np_utils.to_categorical(all_test_y, class_count)

model = Sequential()
model.add(Dense(512, input_shape=(784,)))
model.add(Activation('relu'))
model.add(Dropout(0.2))
model.add(Dense(512))
model.add(Activation('relu'))
model.add(Dropout(0.2))
model.add(Dense(10))
model.add(Activation('softmax'))

model.compile(loss='categorical_crossentropy', optimizer = 'RMSprop', metrics = ['accuracy'])

model.fit(all_train_x, all_train_y, batch_size = 128, nb_epochs = 20, verbose=1)

score = model.evaluate(all_test_x, all_test_y, verbose=1)

print 'Accuracy %.2% %%' % (score[1]*100.)