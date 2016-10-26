using Codemesh.JuggerNET;

namespace Com.MihaiConsulting.Cache
{
    public class CacheNotifier : JuggerNETProxyObject
    {
        private static JavaClass _cmj_theClass = JavaClass.RegisterClass("com.mihaiconsulting.cache.CacheNotifier", typeof(CacheNotifier));
        private static JavaMethod _getInstance = new JavaMethod(_cmj_theClass, typeof(CacheNotifier), "getInstance", "()Lcom/mihaiconsulting/cache/CacheNotifier;", true, false, false);
        private static JavaMethod _setInvalidator = new JavaMethod(_cmj_theClass, typeof(void), "setInvalidator", "(Lcom/mihaiconsulting/cache/CacheInvalidator;)V", false, false, false);

        public CacheNotifier(JNIHandle objectHandle) : base(objectHandle) { }

        public static CacheNotifier Instance
        {
            get
            {
                return (CacheNotifier)_getInstance.CallObject(null, typeof(CacheNotifier), false);
            }
        }

        public ICacheInvalidator Invalidator
        {
            set
            {
                jvalue[] cmj_jargs = new jvalue[1];
                using (JavaMethodArguments cmj_jmargs = new JavaMethodArguments(cmj_jargs).Add(value, typeof(ICacheInvalidator)))
                {
                    _setInvalidator.CallVoid(this, cmj_jmargs);
                }
            }
        }
    }
}