package org.pgm.navermapapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraAnimation
import com.naver.maps.map.CameraPosition
import com.naver.maps.map.CameraUpdate
import com.naver.maps.map.MapFragment
import com.naver.maps.map.NaverMap
import com.naver.maps.map.NaverMapOptions
import com.naver.maps.map.OnMapReadyCallback
import com.naver.maps.map.overlay.Marker

class MapTranActivity : AppCompatActivity(), OnMapReadyCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_tran)

        val options = NaverMapOptions()
            .camera(CameraPosition(LatLng(35.1798159, 129.0750222), 12.0))
            .mapType(NaverMap.MapType.Terrain)

        val fm=supportFragmentManager
        val mapFragment=fm.findFragmentById(R.id.map) as MapFragment?
            ?: MapFragment.newInstance(options).also {
                fm.beginTransaction().add(R.id.map, it).commit()
            }
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(naverMap: NaverMap) {
        //TODO("Not yet implemented")
        val marker=Marker()
        marker.position=LatLng(37.5670135, 126.9783740)
        marker.map=naverMap

        val cameraUpdate= CameraUpdate.scrollTo(LatLng(37.5670135, 126.9783740))
            .animate(CameraAnimation.Fly,2000)
        naverMap.moveCamera(cameraUpdate)

        naverMap.mapType=NaverMap.MapType.Basic
        naverMap.setLayerGroupEnabled(NaverMap.LAYER_GROUP_TRAFFIC,true)
        val coord = LatLng(37.5670135, 126.9783740)
        Log.d("aaaaaaaaaaaaaa","위도: ${coord.latitude}, 경도: ${coord.longitude}")
    }
}