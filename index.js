import {NativeModules, DeviceEventEmitter, Platform} from 'react-native'

const { HeadlessModule } = NativeModules

const Headless = {}


Headless.runTask = (taskKey, args = {}, timeout = 0, allowedInForeground = false) => {
  if (!taskKey) {
    throw new Error("taskKey is required for start task")
  }
  HeadlessModule.runTask(taskKey, args, timeout, allowedInForeground)
}


export default Headless
