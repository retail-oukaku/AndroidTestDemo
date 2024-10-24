set(CMAKE_C_COMPILER_WORKS TRUE)
set(CMAKE_CXX_COMPILER_WORKS TRUE)

cmake_minimum_required(VERSION 3.4.1)
project("gbp-camera")

# 导入dlib静态库
add_library(dlib STATIC IMPORTED)
set_target_properties(dlib PROPERTIES IMPORTED_LOCATION ${CMAKE_SOURCE_DIR}/dlib/lib/libdlib.a)

# 包含dlib头文件
include_directories(${CMAKE_SOURCE_DIR}/dlib/include)

# 添加你的本地共享库
add_library(native-lib SHARED ../../../src/main/cpp/native-lib.cpp)

# 查找系统的log库
find_library(log-lib log)

# 链接dlib和log库到native-lib库
target_link_libraries(native-lib dlib ${log-lib})
