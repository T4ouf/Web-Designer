#pragma once

#ifdef WD_PLATFORM_WINDOWS

#else
	#error The Web Designer only supports Windows!
#endif

//Assertions
#ifdef WD_ENABLE_ASSERTS
	// Windows only debugbreak for now...
	#define WD_ASSERT(x, ...) { if(!(x)) { WD_ERROR("Assertion Failed: {0}", __VA_ARGS__); __debugbreak(); } }
#else
	#define WD_ASSERT(x, ...) 
#endif
