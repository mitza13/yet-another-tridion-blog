using Codemesh.JuggerNET;

namespace Com.MihaiConsulting.Cache
{
    public class CacheInvalidator : JuggerNETProxyObject
    {
        private static JavaClass _cmj_theClass = JavaClass.RegisterClass("com.mihaiconsulting.cache.CacheInvalidator", typeof(ICacheInvalidator), typeof(CacheInvalidator), typeof(CacheInvalidatorCallback));

        public CacheInvalidator(JNIHandle objectHandle) : base(objectHandle) { }
    }
}